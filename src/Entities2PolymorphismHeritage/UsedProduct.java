package Entities2PolymorphismHeritage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UsedProduct extends Product {

    private Date manufactureDate;

    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        return getName()
                + " (used) $ "
                + String.format("%.2f", getPrice())
                + " (Manufacture date: "
                + simpleDateFormat.format(manufactureDate)
                + ")";
    }
}
