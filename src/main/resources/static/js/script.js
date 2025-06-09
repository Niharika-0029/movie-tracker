let currentMovieId = null;
const ratingModal = new bootstrap.Modal(document.getElementById('ratingModal'));

function markAsWatched(movieId) {
    currentMovieId = movieId;
    ratingModal.show();
}

function submitRating() {
    const rating = document.getElementById('ratingInput').value;
    if (rating && rating >= 1 && rating <= 10) {
        const form = document.createElement('form');
        form.method = 'POST';
        form.action = `/movies/${currentMovieId}/watch`;

        const ratingInput = document.createElement('input');
        ratingInput.type = 'hidden';
        ratingInput.name = 'rating';
        ratingInput.value = rating;

        form.appendChild(ratingInput);
        document.body.appendChild(form);
        form.submit();
    }
}
