package my.project.Restaurant.controller;

import my.project.Restaurant.model.Reservation;
import my.project.Restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")  // Use a unified URL
@CrossOrigin(origins = "http://127.0.0.1:5501/") // Allow frontend access
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.createReservation(reservation);
        return ResponseEntity.ok(savedReservation);  // Send back the saved reservation
    }
}
