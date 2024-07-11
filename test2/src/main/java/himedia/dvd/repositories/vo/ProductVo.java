package himedia.dvd.repositories.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductVo {
    private Long productNo;      // 상품 번호
    private String productName;  // 상품 이름
    private String genre;         // 상품 장르
    private String releaseDate;    // 상품 등록일
    private String content;      // 상품 설명
    private String status;       // 대여 가능 여부
    private String img;          // 상품 이미지 URL

    public ProductVo() {
    }

    // 상품 등록용 생성자
    public ProductVo(String productName, String genre, String releaseDate, String content, String status, String img) {
        this.productName = productName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.content = content;
        this.status = status;
        this.img = img;
    }

    // 리스트 출력용 생성자
    public ProductVo(Long productNo, String productName, String genre, String releaseDate, String status) {
        this.productNo = productNo;
        this.productName = productName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.status = status;
    }

    // 상세정보 출력용 생성자
    public ProductVo(Long productNo, String productName, String genre, String releaseDate, String content, String status) {
        this.productNo = productNo;
        this.productName = productName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.content = content;
        this.status = status;
    }
    
    //수정용 

    public Long getProductNo() {
        return productNo;
    }

    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "ProductVo [productNo=" + productNo + ", productName=" + productName + ", genre=" + genre
                + ", releaseDate=" + releaseDate + ", content=" + content + ", status=" + status + ", img=" + img + "]";
    }
}
