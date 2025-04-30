   // Gérer la soumission du formulaire
        document.getElementById('connexionForm').addEventListener('submit', function(e) {
            e.preventDefault();
            alert('Inscription réussie !');
            closeModal();
        });

        // Fermer le modal
        function closeModal() {
            document.getElementById('connexionModal').style.display = 'none';
        }