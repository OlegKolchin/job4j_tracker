package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection connection) {
        cn = connection;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().
                getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("hibernate.connection.driver_class"));
            cn = DriverManager.getConnection(
                    config.getProperty("hibernate.connection.url"),
                    config.getProperty("hibernate.connection.username"),
                    config.getProperty("hibernate.connection.password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement("insert into items(name) values (?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set name = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Item> parse(String sql) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(resultSet.getInt("id"),
                            resultSet.getString("name")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findAll() {
        String sql = "select * from items";
        return parse(sql);
    }

    @Override
    public List<Item> findByName(String key) {
        String sql = String.format("select * from items where name='%s'", key);
        return parse(sql);
    }

    @Override
    public Item findById(int id) {
        String s = String.format("select * from items where id=%s", id);
        try (PreparedStatement statement = cn.prepareStatement(s)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item();
                    item.setId(resultSet.getInt("id"));
                    item.setName(resultSet.getString("name"));
                    return item;
                }
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}