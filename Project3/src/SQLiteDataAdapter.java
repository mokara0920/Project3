
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataAdapter implements IDataAdapter {
    String dbString = "/Users/shenchuang/Desktop/Assignment4/data/store.db";
    Connection conn = null;

    public int connect(String dbfile) {
        try {
            // db parameters
            String url = "jdbc:sqlite:" + dbfile;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return CONNECTION_OPEN_FAILED;
        }
        return CONNECTION_OPEN_OK;
    }

    @Override
    public int disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return CONNECTION_CLOSE_FAILED;
        }
        return CONNECTION_CLOSE_OK;
    }

    public ProductModel loadProduct(int productID) {
        ProductModel product = null;

        try {
            connect(dbString);
            String sql = "SELECT ProductId, Name, Price, Quantity FROM Product WHERE ProductId = " + productID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                product = new ProductModel();
                product.mProductID = rs.getInt("ProductId");
                product.mName = rs.getString("Name");
                product.mPrice = rs.getDouble("Price");
                product.mQuantity = rs.getDouble("Quantity");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            disconnect();
        }
        return product;
    }
    public int saveProduct(ProductModel product) {
        try {
            connect(dbString);
            Statement stmt = conn.createStatement();
            ProductModel p = loadProduct(product.mProductID); // check if this product exists
            if (p != null) {
                stmt.executeUpdate("DELETE FROM Product WHERE ProductID = " + product.mProductID);
            }

            String sql = "INSERT INTO Product(ProductId, Name, Price, Quantity) VALUES " + product;
            System.out.println(sql);

            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed"))
                return PRODUCT_SAVE_FAILED;
        }finally {
            disconnect();
        }

        return PRODUCT_SAVE_OK;
    }

    public int savePurchase(PurchaseModel purchase) {
        try {
            connect(dbString);
            Statement stmt = conn.createStatement();
            PurchaseModel p = loadPurchase(purchase.mPurchaseID);
            if (p != null) {
                stmt.executeUpdate("DELETE FROM Purchase WHERE PurchaseID = " + purchase.mPurchaseID);
            }
            String sql = "INSERT INTO Purchase VALUES " + purchase;
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed"))
                return PURCHASE_SAVE_FAILED;
        }finally {
            disconnect();
        }

        return PURCHASE_SAVE_OK;

    }

    public PurchaseModel loadPurchase(int id) {
        PurchaseModel purchase = null;

        try {
            connect(dbString);
            String sql = "SELECT * FROM Purchase WHERE purchaseID = " + id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                purchase = new PurchaseModel();
                purchase.mPurchaseID = rs.getInt("purchaseID");;
                purchase.mCustomerID = rs.getInt("customerID");
                purchase.mProductID = rs.getInt("productID");
                purchase.mPrice = rs.getDouble("price");
                purchase.mQuantity = rs.getInt("quantity");
                purchase.mCost = rs.getDouble("cost");
                purchase.mTax = rs.getDouble("tax");
                purchase.mTotal = rs.getDouble("totalCost");
                purchase.mDate = rs.getString("date");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            disconnect();
        }
        return purchase;
    }

    public CustomerModel loadCustomer(int id) {
        CustomerModel customer = null;

        try {
            connect(dbString);
            String sql = "SELECT * FROM Customer WHERE CustomerId = " + id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                customer = new CustomerModel();
                customer.mCustomerID = id;
                customer.mName = rs.getString("Name");
                customer.mPhone = rs.getString("Phone");
                customer.mAddress = rs.getString("Address");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            disconnect();
        }
        return customer;
    }


    public int saveCustomer(CustomerModel customer) {
        try {
            connect(dbString);
            Statement stmt = conn.createStatement();
            CustomerModel c = loadCustomer(customer.mCustomerID); // check if this product exists
            if (c != null) {
                stmt.executeUpdate("DELETE FROM Customer WHERE CustomerID = " + customer.mCustomerID);
            }

            String sql = "INSERT INTO Customer(CustomerId, Name, Phone, Address) VALUES " + customer;
            System.out.println(sql);

            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed"))
                return PRODUCT_SAVE_FAILED;
        }finally {
            disconnect();
        }
        return PRODUCT_SAVE_OK;
    }
}
