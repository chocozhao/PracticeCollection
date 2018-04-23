package json.bean;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by 赵泳霖 on 2017/11/21.
 */

public class DataInfo {

    @Override
    public String toString() {
        return "DataInfo{" +
                "data=" + data +
                '}';
    }

    /**
     * data : {"count":5,"trailers":[{"id":68379,"movieName":"《拓星者》先行版预告","coverImg":"http://img5.mtime.cn/mg/2017/11/13/105245.83405580_120X90X4.jpg","movieId":232881,"url":"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4","hightUrl":"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4","videoTitle":"拓星者 先行版预告","videoLength":78,"rating":-1,"type":["动作","科幻","冒险"],"summary":"国产科幻 外星荒漠挣扎求生"},{"id":68309,"movieName":"《比得兔》中文预告","coverImg":"http://img5.mtime.cn/mg/2017/11/08/093909.60048379_120X90X4.jpg","movieId":240443,"url":"http://vfx.mtime.cn/Video/2017/11/08/mp4/171108093937333122.mp4","hightUrl":"http://vfx.mtime.cn/Video/2017/11/08/mp4/171108093937333122.mp4","videoTitle":"比得兔 中文版剧场预告片","videoLength":133,"rating":-1,"type":["动画","冒险","喜剧","家庭","奇幻"],"summary":"比得兔与农场主斗智斗勇"},{"id":68391,"movieName":"《勇敢者的游戏》预告","coverImg":"http://img5.mtime.cn/mg/2017/06/30/111434.76339580.jpg","movieId":227232,"url":"http://vfx.mtime.cn/Video/2017/11/14/mp4/171114092423896713.mp4","hightUrl":"http://vfx.mtime.cn/Video/2017/11/14/mp4/171114092423896713.mp4","videoTitle":"勇敢者游戏：决战丛林 \"身陷兽群\"预告片","videoLength":96,"rating":-1,"type":["动作","冒险","喜剧","家庭","奇幻"],"summary":"问题学生意外闯入冒险游戏"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        /**
         * count : 5
         * trailers : [{"id":68379,"movieName":"《拓星者》先行版预告","coverImg":"http://img5.mtime.cn/mg/2017/11/13/105245.83405580_120X90X4.jpg","movieId":232881,"url":"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4","hightUrl":"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4","videoTitle":"拓星者 先行版预告","videoLength":78,"rating":-1,"type":["动作","科幻","冒险"],"summary":"国产科幻 外星荒漠挣扎求生"},{"id":68309,"movieName":"《比得兔》中文预告","coverImg":"http://img5.mtime.cn/mg/2017/11/08/093909.60048379_120X90X4.jpg","movieId":240443,"url":"http://vfx.mtime.cn/Video/2017/11/08/mp4/171108093937333122.mp4","hightUrl":"http://vfx.mtime.cn/Video/2017/11/08/mp4/171108093937333122.mp4","videoTitle":"比得兔 中文版剧场预告片","videoLength":133,"rating":-1,"type":["动画","冒险","喜剧","家庭","奇幻"],"summary":"比得兔与农场主斗智斗勇"},{"id":68391,"movieName":"《勇敢者的游戏》预告","coverImg":"http://img5.mtime.cn/mg/2017/06/30/111434.76339580.jpg","movieId":227232,"url":"http://vfx.mtime.cn/Video/2017/11/14/mp4/171114092423896713.mp4","hightUrl":"http://vfx.mtime.cn/Video/2017/11/14/mp4/171114092423896713.mp4","videoTitle":"勇敢者游戏：决战丛林 \"身陷兽群\"预告片","videoLength":96,"rating":-1,"type":["动作","冒险","喜剧","家庭","奇幻"],"summary":"问题学生意外闯入冒险游戏"}]
         */

        private int count;
        private List<TrailersBean> trailers;

        @Override
        public String toString() {
            return "DataBean{" +
                    "count=" + count +
                    ", trailers=" + trailers +
                    '}';
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<TrailersBean> getTrailers() {
            return trailers;
        }

        public void setTrailers(List<TrailersBean> trailers) {
            this.trailers = trailers;
        }



        public static class TrailersBean {
            /**
             * id : 68379
             * movieName : 《拓星者》先行版预告
             * coverImg : http://img5.mtime.cn/mg/2017/11/13/105245.83405580_120X90X4.jpg
             * movieId : 232881
             * url : http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4
             * hightUrl : http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4
             * videoTitle : 拓星者 先行版预告
             * videoLength : 78
             * rating : -1
             * type : ["动作","科幻","冒险"]
             * summary : 国产科幻 外星荒漠挣扎求生
             */

            private int id;
            private String movieName;
            private String coverImg;
            private int movieId;
            private String url;
            private String hightUrl;
            private String videoTitle;
            private int videoLength;
            private int rating;
            private String summary;

            @Override
            public String toString() {
                return "TrailersBean{" +
                        "id=" + id +
                        ", movieName='" + movieName + '\'' +
                        ", coverImg='" + coverImg + '\'' +
                        ", movieId=" + movieId +
                        ", url='" + url + '\'' +
                        ", hightUrl='" + hightUrl + '\'' +
                        ", videoTitle='" + videoTitle + '\'' +
                        ", videoLength=" + videoLength +
                        ", rating=" + rating +
                        ", summary='" + summary + '\'' +
                        ", type=" + type +
                        '}';
            }

            private List<String> type;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMovieName() {
                return movieName;
            }

            public void setMovieName(String movieName) {
                this.movieName = movieName;
            }

            public String getCoverImg() {
                return coverImg;
            }

            public void setCoverImg(String coverImg) {
                this.coverImg = coverImg;
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

            public String getVideoTitle() {
                return videoTitle;
            }

            public void setVideoTitle(String videoTitle) {
                this.videoTitle = videoTitle;
            }

            public int getVideoLength() {
                return videoLength;
            }

            public void setVideoLength(int videoLength) {
                this.videoLength = videoLength;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public List<String> getType() {
                return type;
            }

            public void setType(List<String> type) {
                this.type = type;
            }
        }
    }
}
