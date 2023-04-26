package VideoProject.video.videostore;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

public class Video {
    private UUID id;
    @NotBlank(message = "name may not be blank")
    private String name;
    private Genre genre;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private boolean isRental = false;

    public Video(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public Enum getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
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

    public boolean getRental() {
        return isRental;
    }

    public void setRental(boolean rental) {
        isRental = rental;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", isRental=" + isRental +
                '}';
    }
}

