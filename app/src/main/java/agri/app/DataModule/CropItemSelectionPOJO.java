package agri.app.DataModule;

public class CropItemSelectionPOJO{
        private String content;
        private String imageResource;
        private int itemPosition;

        public CropItemSelectionPOJO(String content, String imageResource) {
            this.content = content;
            this.imageResource = imageResource;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImageResource() {
            return imageResource;
        }

        public void setImageResource(String imageResource) {
            this.imageResource = imageResource;
        }

}