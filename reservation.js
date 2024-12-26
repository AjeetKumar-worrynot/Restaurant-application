document.getElementById("reservationForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const reservation = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        date: document.getElementById("date").value,
        time: document.getElementById("time").value,
    };

    try {
        const response = await fetch("http://localhost:8080/api/reservations", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(reservation),
        });

        if (response.ok) {
            alert("Reservation successful!");
            document.getElementById("reservationForm").reset();
        } else {
            alert("Failed to make a reservation. Please try again.");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("An error occurred. Please try again later.");
    }
});
