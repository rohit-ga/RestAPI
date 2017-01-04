package com.ga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ga.database.Database;
import com.ga.model.User;

public class UserDao {

    private static final String LOGIN_VALIDATION_QUERY = "select email, password from user where email=? and password=?";
    private static final String CHECK_USER_QUERY = "select email from user where email=?";
    private static final String REGISTER_USER_QUERY = "insert into user VALUES (?,?,?,?,?,?)";
    private static final String GET_USERS_LIST_QUERY = "select * from user";
    private static final String DELETE_USER_QUERY = "delete from user where id = ?";
    private static final String GET_USER_BY_ID_QUERY = "select * from user where id = ?";
    private static final String UPDATE_USER_QUERY = "update user set firstname=?,lastname=?,contact=? where id = ?";
    private static final String GET_USER_DETAILS_BY_EMAIL_QUERY = "select * from user where email=?";

    public String registerUser(User user) {

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;

        try {
            connection = Database.doConnection();
            pst = connection.prepareStatement(CHECK_USER_QUERY);
            pst.setString(1, user.getEmail());

            rs = pst.executeQuery();

            if (rs.next()) {

                return "This Email Is Already Registered";

            } else {

                pst = connection.prepareStatement(REGISTER_USER_QUERY);
                pst.setInt(1, 0);
                pst.setString(2, user.getFirstName());
                pst.setString(3, user.getLastName());
                pst.setString(4, user.getContact());
                pst.setString(5, user.getEmail());
                pst.setString(6, user.getPassword());
                pst.executeUpdate();

                return "Regisered Successfully";
            }
        } catch (SQLException e) {
            System.out.println("Error in registerUser() catching:- " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error in registerUser() finally:- " + e.getMessage());
                }
            }

        }
        return null;
    }

    public String loginUser(String email, String password) {

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;

        try {
            connection = Database.doConnection();
            pst = connection.prepareStatement(LOGIN_VALIDATION_QUERY);
            pst.setString(1, email);
            pst.setString(2, password);

            rs = pst.executeQuery();

            if (rs.next()) {
                return "Login Successful";
            } else {
                return "Credentials are mismatched. Please Retry";
            }
        } catch (SQLException e) {
            System.out.println("Error in loginUser() catching:- " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error in loginUser() finally:- " + e.getMessage());
                }
            }

        }
        return null;
    }

    public List<User> getAllUser() {

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        List<User> userList = new ArrayList<User>();

        try {
            connection = Database.doConnection();
            pst = connection.prepareStatement(GET_USERS_LIST_QUERY);

            rs = pst.executeQuery();

            while (rs.next()) {
                User dbUser = new User();
                dbUser.setId(rs.getInt("id"));
                dbUser.setFirstName(rs.getString("firstname"));
                dbUser.setLastName(rs.getString("lastname"));
                dbUser.setEmail(rs.getString("email"));
                dbUser.setContact(rs.getString("contact"));
                userList.add(dbUser);
            }
        } catch (SQLException e) {
            System.out.println("Error in getAllUser() catching:- " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error in getAllUser() finally:- " + e.getMessage());
                }
            }
        }
        return userList;
    }

    public String deleteUserById(int id) {

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;

        try {
            connection = Database.doConnection();
            pst = connection.prepareStatement(GET_USER_BY_ID_QUERY);
            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {
                pst = connection.prepareStatement(DELETE_USER_QUERY);
                pst.executeUpdate();

                return "Data Successfully Deleted";
            } else {
                return "Data not found";
            }
        } catch (SQLException e) {
            System.out.println("Error in deleteUserById() catching:- " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error in deleteUserById() finally:- " + e.getMessage());
                }
            }
        }
        return null;
    }

    public User getUserById(int id) {

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;

        try {
            connection = Database.doConnection();
            pst = connection.prepareStatement(GET_USER_BY_ID_QUERY);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            if (rs.next()) {
                User dbUser = new User();
                dbUser.setFirstName(rs.getString("firstname"));
                dbUser.setLastName(rs.getString("lastname"));
                dbUser.setContact(rs.getString("contact"));
                return dbUser;
            } else {
                return new User("UserID Doesn't Exist");
            }
        } catch (SQLException e) {
            System.out.println("Error in getUserById() catching:- " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error in getUserById() finally:- " + e.getMessage());
                }
            }
        }
        return null;
    }

    public String updateUser(int id, User user1) {

        Connection connection = null;
        PreparedStatement pst;

        try {
            connection = Database.doConnection();
            pst = connection.prepareStatement(UPDATE_USER_QUERY);
            pst.setString(1, user1.getFirstName());
            pst.setString(2, user1.getLastName());
            pst.setString(3, user1.getContact());
            pst.setInt(4, id);
            pst.executeUpdate();
            return "Data Updated Successfully";

        } catch (SQLException e) {
            System.out.println("Error in updateUser() catching:- " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error in updateUser() finally:- " + e.getMessage());
                }
            }
        }
        return null;
    }

    public User getUserDetails(String email) {

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;

        try {
            connection = Database.doConnection();
            pst = connection.prepareStatement(GET_USER_DETAILS_BY_EMAIL_QUERY);
            pst.setString(1, email);

            rs = pst.executeQuery();

            if (rs.next()) {
                User dbUser = new User();
                dbUser.setFirstName(rs.getString("firstname"));
                dbUser.setLastName(rs.getString("lastname"));
                dbUser.setContact(rs.getString("contact"));
                return dbUser;
            } else {
                return new User("Invalid Email");
            }
        } catch (SQLException e) {
            System.out.println("Error in getUserDetails() catching:- " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error in getUserDetails() finally:- " + e.getMessage());
                }
            }
        }
        return null;
    }

    public String addUser(User user1) {

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;

        try {
            connection = Database.doConnection();
            pst = connection.prepareStatement(CHECK_USER_QUERY);
            pst.setString(1, user1.getEmail());
            rs = pst.executeQuery();

            if (rs.next()) {

                return "This Email Is Already Registered";

            } else {

                pst = connection.prepareStatement(REGISTER_USER_QUERY);
                pst.setInt(1, 0);
                pst.setString(2, user1.getFirstName());
                pst.setString(3, user1.getLastName());
                pst.setString(4, user1.getContact());
                pst.setString(5, user1.getEmail());
                pst.setString(6, user1.getPassword());
                pst.executeUpdate();

                return "Regisered Successfully";
            }
        } catch (SQLException e) {
            System.out.println("Error in getUserDetails() catching:- " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error in getUserDetails() finally:- " + e.getMessage());
                }
            }
        }
        return null;
    }

}