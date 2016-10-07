/**
 * Created by qiqi on 2016/10/6.
 */
public class MusicAlbum {
    private String albumTitle;
    private String singer;
    private double price;

    public MusicAlbum(String albumTile, String singer, Double price) {
        this.albumTitle = albumTile;
        this.singer = singer;
        this.price = price;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getSinger() {
        return singer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double newPrice) {
        price = newPrice;
        return;
    }

    public static void main(String[] args) {
        MusicAlbum rose = new MusicAlbum("rose", "Johm", 5.0);
        System.out.println(rose.getAlbumTitle());
        System.out.println(rose.getSinger());
        System.out.println(rose.getPrice());
    }
}
