 // Toggle API details
        function toggleDetails(id) {
            const element = document.getElementById(id);
            element.classList.toggle('open');

            // Change chevron icon
            const button = element.previousElementSibling.querySelector('button');
            const icon = button.querySelector('i');
            if (element.classList.contains('open')) {
                icon.classList.remove('fa-chevron-down');
                icon.classList.add('fa-chevron-up');
            } else {
                icon.classList.remove('fa-chevron-up');
                icon.classList.add('fa-chevron-down');
            }
        }

        // Mobile menu toggle would go here if we had one