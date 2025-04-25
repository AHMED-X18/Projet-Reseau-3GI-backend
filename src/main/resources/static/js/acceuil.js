// Animation pour les cartes API
        document.querySelectorAll('.api-card').forEach(card => {
            card.addEventListener('mouseenter', () => {
                card.style.transform = 'translateY(-5px)';
                card.style.boxShadow = '0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04)';
            });
            card.addEventListener('mouseleave', () => {
                card.style.transform = '';
                card.style.boxShadow = '';
            });
        });

        // Animation pour les éléments du menu
        document.querySelectorAll('.menu-item').forEach(item => {
            item.addEventListener('mouseenter', () => {
                item.style.background = 'rgba(255, 255, 255, 0.1)';
                item.style.transform = 'translateX(5px)';
            });
            item.addEventListener('mouseleave', () => {
                item.style.background = '';
                item.style.transform = '';
            });
        });

        // Animation pour les tags de catégorie
        document.querySelectorAll('.category-tag').forEach(tag => {
            tag.addEventListener('mouseenter', () => {
                tag.style.transform = 'scale(1.05)';
            });
            tag.addEventListener('mouseleave', () => {
                tag.style.transform = '';
            });
        });