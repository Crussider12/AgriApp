package agri.app.DataModule;

public class CropSelectItemReq {
    private String data;
    private String cropItemReqName;
    private String cropItemReqQuant;

    public CropSelectItemReq(String name, String itemQuant) {

        this.cropItemReqQuant = itemQuant;
        this.cropItemReqName = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCropItemReqName() {
        return cropItemReqName;
    }

    public void setCropItemReqName(String cropItemReqName) {
        this.cropItemReqName = cropItemReqName;
    }


    public String getCropItemReqQuant() {
        return cropItemReqQuant;
    }

    public void setCropItemReqQuant(String cropItemReqQuant) {
        this.cropItemReqQuant = cropItemReqQuant;
    }

}
