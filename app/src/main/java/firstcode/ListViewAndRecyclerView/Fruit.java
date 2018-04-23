package firstcode.ListViewAndRecyclerView;

/**
 * Created by 赵泳霖 on 2017/8/7.
 */

public class Fruit  {
    private String name;
    private int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
