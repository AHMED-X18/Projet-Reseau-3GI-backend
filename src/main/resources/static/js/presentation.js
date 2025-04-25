 // Messages de bienvenue aléatoires
        const welcomeMessages = [
            "Bienvenue sur la plateforme ultime de gestion d'API !",
            "Découvrez une nouvelle façon de gérer vos API avec nous.",
            "Votre solution complète pour toutes les API en un seul endroit.",
            "Connectez-vous et explorez le pouvoir de nos outils API.",
            "Simplifiez votre architecture microservices dès aujourd'hui."
        ];

        // Témoignages aléatoires
        const testimonials = [
            {
                name: "Jean Dupont",
                role: "CTO, TechSolutions",
                content: "Cette plateforme a révolutionné notre gestion des API. Tout est si intuitif et puissant !",
                rating: 5
            },
            {
                name: "Marie Lambert",
                role: "Développeuse Fullstack",
                content: "La documentation automatique m'a fait gagner des heures de travail. Je recommande vivement.",
                rating: 4
            },
            {
                name: "Thomas Martin",
                role: "Architecte Logiciel",
                content: "La sécurité avancée et le monitoring en temps réel sont des game-changers pour notre entreprise.",
                rating: 5
            },
            {
                name: "Sophie Leroy",
                role: "Product Manager",
                content: "L'interface est tellement bien conçue que même nos non-techniciens peuvent l'utiliser.",
                rating: 5
            },
            {
                name: "Alexandre Petit",
                role: "DevOps Engineer",
                content: "Intégration facile avec nos outils existants. Le support est également excellent.",
                rating: 4
            }
        ];

        // Générer un message de bienvenue aléatoire
        document.getElementById('welcomeMessage').textContent =
            welcomeMessages[Math.floor(Math.random() * welcomeMessages.length)];

        // Générer 3 témoignages aléatoires
        const testimonialsContainer = document.getElementById('testimonialsContainer');
        const shuffledTestimonials = [...testimonials].sort(() => 0.5 - Math.random()).slice(0, 3);

        shuffledTestimonials.forEach(testimonial => {
            const stars = '★'.repeat(testimonial.rating) + '☆'.repeat(5 - testimonial.rating);

            const testimonialCard = document.createElement('div');
            testimonialCard.className = 'glass-effect p-6 rounded-xl testimonial-card';
            testimonialCard.innerHTML = `
                <div class="flex items-center mb-4">
                    <div class="w-12 h-12 bg-gradient-to-r from-blue-500 to-purple-600 rounded-full flex items-center justify-center mr-3">
                        <i class="fas fa-user text-white"></i>
                    </div>
                    <div>
                        <h4 class="font-bold">${testimonial.name}</h4>
                        <p class="text-sm text-gray-400">${testimonial.role}</p>
                    </div>
                </div>
                <p class="text-gray-300 mb-3">"${testimonial.content}"</p>
                <div class="text-yellow-400">${stars}</div>
            `;

            testimonialsContainer.appendChild(testimonialCard);
        });