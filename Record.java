public class Record {
    int id, qty;
    String ProductName;

    public Record(){

    }

    public Record(int id, int qty, String ProductName){
        this.id = id;
        this.qty = qty;
        this.ProductName = ProductName;
    }
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String toString()
    {
        return "Records{"+"PID: "+id +" Product Name: "+ProductName+" Quantity: "+qty+ '}';
    }
}

    
    

    
    


