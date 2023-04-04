package VideoProject.video.videostore;

import java.time.LocalDate;

public class Video {
    private Long id;
    private String name;
    private Integer RunningTime;
    private Enum genre;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public Video(Long id, String name, Integer runningTime, Enum genre) {
        this.id = id;
        this.name = name;
        RunningTime = runningTime;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRunningTime() {
        return RunningTime;
    }

    public void setRunningTime(Integer runningTime) {
        RunningTime = runningTime;
    }

    public Enum getGenre() {
        return genre;
    }

    public void setGenre(Enum genre) {
        this.genre = genre;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", RunningTime=" + RunningTime +
                ", genre=" + genre +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                '}';
    }
}

