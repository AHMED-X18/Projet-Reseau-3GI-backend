// Gérer la soumission du formulaire
document.getElementById('Form').addEventListener('submit', function(e) {
    // Optionally, you can add validation or any other logic here


    // Form will be submitted naturally, so we don't need to call preventDefault()
});

// Fermer le modal
function closeModal() {
    document.getElementById('connexionModal').style.display = 'none';
}