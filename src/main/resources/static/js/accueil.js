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

        // Category filter
        document.querySelectorAll('.category-chip').forEach(chip => {
            chip.addEventListener('click', function() {
                document.querySelectorAll('.category-chip').forEach(c => c.classList.remove('active'));
                this.classList.add('active');
            });
        });

        // Mobile menu toggle
        document.getElementById('menu-toggle').addEventListener('click', function() {
            const sidebar = document.querySelector('.sidebar');
            const mainContent = document.querySelector('.main-content');

            if (sidebar.style.width === '0px' || !sidebar.style.width) {
                sidebar.style.width = '250px';
                mainContent.style.marginLeft = '250px';
            } else {
                sidebar.style.width = '0';
                mainContent.style.marginLeft = '0';
            }
        });