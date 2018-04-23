package json.bean;

/**
 * Created by 赵泳霖 on 2017/11/20.
 * 商店实体类
 */
public class ShopInfo {
    private int id;
    private String movieName;
    private String coverImg;
    private int movieId;
    private String url;
    private String hightUrl;
    private int videoTitle;
    private String optString;
    private String type;
    private String summary;

    public ShopInfo(int id, String movieName, String coverImg, int movieId, String url, String hightUrl, String summary, String optString, int videoTitle, String type) {
        this.id = id;
        this.movieName = movieName;
        this.coverImg = coverImg;
        this.movieId = movieId;
        this.url = url;
        this.hightUrl = hightUrl;
        this.summary = summary;
        this.optString = optString;
        this.videoTitle = videoTitle;
        this.type = type;
    }

    public ShopInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHightUrl() {
        return hightUrl;
    }

    public void setHightUrl(String hightUrl) {
        this.hightUrl = hightUrl;
    }

    public int getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(int videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getOptString() {
        return optString;
    }

    public void setOptString(String optString) {
        this.optString = optString;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", movieId=" + movieId +
                ", url='" + url + '\'' +
                ", hightUrl='" + hightUrl + '\'' +
                ", videoTitle=" + videoTitle +
                ", optString='" + optString + '\'' +
                ", type='" + type + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
