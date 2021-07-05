package wlasne;

public class Item {
    private String itemId;
    private String nazwa;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) throws Exception {
        if(!itemId.matches("[A-Z]{4}\\d{6}")){
            throw new Exception("Zły format identyfikatora");
        }
        this.itemId=itemId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Item(String itemId, String nazwa) throws Exception {
        setItemId(itemId);
        this.nazwa = nazwa;
    }

}
