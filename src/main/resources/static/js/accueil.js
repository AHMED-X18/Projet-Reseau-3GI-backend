// Données des APIs
    const apis = [
        {
            id: 1,
            name: "Service d'Authentification",
            category: "authentification",
            description: "Gestion sécurisée des utilisateurs avec JWT, OAuth2 et multi-facteurs.",
            url: "https://api.example.com/auth",
            icon: "fa-user-lock",
            color: "purple",
            endpoints: [
                "/auth/register",
                "/auth/login",
                "/auth/refresh-token",
                "/auth/reset-password"
            ]
        },
        {
            id: 2,
            name: "Service d'Acteurs Commerciaux",
            category: "commerce",
            description: "Gestion des clients, fournisseurs et partenaires commerciaux.",
            url: "https://api.example.com/commercial-actors",
            icon: "fa-users",
            color: "blue",
            endpoints: [
                "/actors/clients",
                "/actors/suppliers",
                "/actors/partners",
                "/actors/opportunities"
            ]
        },
        {
            id: 3,
            name: "Service de Localisation",
            category: "localisation",
            description: "Géocodage, recherche d'adresses et calculs d'itinéraires précis.",
            url: "https://api.example.com/location",
            icon: "fa-map-marker-alt",
            color: "green",
            endpoints: [
                "/location/geocode",
                "/location/reverse-geocode",
                "/location/route",
                "/location/places"
            ]
        },
        {
            id: 4,
            name: "Service de Médias",
            category: "media",
            description: "Stockage et diffusion de contenus multimédias (images, vidéos, documents).",
            url: "https://api.example.com/media",
            icon: "fa-photo-video",
            color: "red",
            endpoints: [
                "/media/upload",
                "/media/list",
                "/media/stream/{id}",
                "/media/metadata"
            ]
        },
        {
            id: 5,
            name: "Service de Notification",
            category: "notification",
            description: "Envoi de notifications push, emails et SMS en temps réel.",
            url: "https://api.example.com/notifications",
            icon: "fa-bell",
            color: "yellow",
            endpoints: [
                "/notifications/send",
                "/notifications/history",
                "/notifications/templates",
                "/notifications/preferences"
            ]
        },
        {
            id: 6,
            name: "Service d'Organisation",
            category: "organisation",
            description: "Gestion des structures hiérarchiques et des équipes.",
            url: "https://api.example.com/organization",
            icon: "fa-sitemap",
            color: "indigo",
            endpoints: [
                "/org/departments",
                "/org/teams",
                "/org/hierarchy",
                "/org/members"
            ]
        },
        {
            id: 7,
            name: "Service de Paiement",
            category: "paiement",
            description: "Transactions sécurisées avec support pour cartes, virements et crypto.",
            url: "https://api.example.com/payment",
            icon: "fa-credit-card",
            color: "pink",
            endpoints: [
                "/payment/process",
                "/payment/refund",
                "/payment/subscriptions",
                "/payment/history"
            ]
        },
        {
            id: 8,
            name: "Service de Ressources",
            category: "ressources",
            description: "Gestion centralisée des ressources matérielles et logicielles.",
            url: "https://api.example.com/resources",
            icon: "fa-boxes",
            color: "teal",
            endpoints: [
                "/resources/inventory",
                "/resources/allocation",
                "/resources/monitoring",
                "/resources/maintenance"
            ]
        },
        {
            id: 9,
            name: "Service de Chatbot",
            category: "chatbot",
            description: "Assistant conversationnel intelligent avec NLP et intégrations multi-canaux.",
            url: "https://api.example.com/chatbot",
            icon: "fa-robot",
            color: "gray",
            endpoints: [
                "/chatbot/conversations",
                "/chatbot/intents",
                "/chatbot/analyze",
                "/chatbot/train"
            ]
        }
    ];

    // Couleurs pour les catégories
    const colorMap = {
        authentification: "bg-purple-100 text-purple-600",
        commerce: "bg-blue-100 text-blue-600",
        localisation: "bg-green-100 text-green-600",
        media: "bg-red-100 text-red-600",
        notification: "bg-yellow-100 text-yellow-600",
        organisation: "bg-indigo-100 text-indigo-600",
        paiement: "bg-pink-100 text-pink-600",
        ressources: "bg-teal-100 text-teal-600",
        chatbot: "bg-gray-100 text-gray-600"
    };

    // Afficher les APIs
    function displayAPIs(filteredAPIs = apis) {
        const container = document.getElementById('apiContainer');
        container.innerHTML = '';

        filteredAPIs.forEach(api => {
            const colorClass = colorMap[api.category];
            const card = document.createElement('div');
            card.className = 'api-card bg-white rounded-xl shadow-md overflow-hidden transition duration-300';
            card.innerHTML = `
                <div class="p-6">
                    <div class="flex items-center mb-4">
                        <div class="w-12 h-12 rounded-full ${colorClass.replace('text', 'bg')} flex items-center justify-center mr-4">
                            <i class="fas ${api.icon} ${colorClass} text-xl"></i>
                        </div>
                        <div>
                            <h4 class="font-bold text-xl text-gray-800">${api.name}</h4>
                            <span class="text-sm text-gray-500 capitalize">${api.category.replace('-', ' ')}</span>
                        </div>
                    </div>
                    <p class="text-gray-600 mb-4">${api.description}</p>
                    <div class="flex justify-between items-center">
                        <span class="text-sm text-gray-500"><i class="fas fa-link mr-1"></i> ${api.url}</span>
                    </div>
                </div>
                <div class="px-6 pb-4">
                    <button onclick="toggleDetails('details${api.id}')" class="text-blue-600 font-medium flex items-center">
                        Voir détails <i class="fas fa-chevron-down ml-2 text-sm"></i>
                    </button>
                </div>
                <div id="details${api.id}" class="api-details px-6 pb-6">
                    <div class="border-t pt-4">
                        <h5 class="font-bold mb-2">Endpoints disponibles:</h5>
                        <ul class="space-y-2">
                            ${api.endpoints.map(endpoint =>
                                `<li class="flex items-center"><i class="fas fa-circle text-xs ${colorClass.replace('bg-100', '500')} mr-2"></i> ${endpoint}</li>`
                            ).join('')}
                        </ul>
                        <div class="mt-4 flex justify-between items-center">
                            <a href="${api.url}" target="_blank" class="text-blue-600 font-medium">
                                <i class="fas fa-external-link-alt mr-2"></i> Visiter le site
                            </a>
                            <button class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition">
                                <i class="fas fa-key mr-2"></i> Obtenir une clé API
                            </button>
                        </div>
                    </div>
                </div>
            `;
            container.appendChild(card);
        });
    }

    // Fonction de recherche
    function searchAPIs() {
        const searchTerm = document.getElementById('searchInput').value.toLowerCase();
        const filtered = apis.filter(api =>
            api.name.toLowerCase().includes(searchTerm) ||
            api.description.toLowerCase().includes(searchTerm) ||
            api.category.toLowerCase().includes(searchTerm)
        );
        displayAPIs(filtered);
    }

    // Fonction de filtrage par catégorie
    function filterAPIs(category) {
        // Mise à jour des boutons actifs
        document.querySelectorAll('.category-chip').forEach(btn => {
            btn.classList.remove('active');
        });
        event.target.classList.add('active');

        if (category === 'all') {
            displayAPIs(apis);
        } else {
            const filtered = apis.filter(api => api.category === category);
            displayAPIs(filtered);
        }
    }

    // Toggle détails API
    function toggleDetails(id) {
        const details = document.getElementById(id);
        if (details.style.display === 'block') {
            details.style.display = 'none';
            event.target.innerHTML = 'Voir détails <i class="fas fa-chevron-down ml-2 text-sm"></i>';
        } else {
            details.style.display = 'block';
            event.target.innerHTML = 'Masquer détails <i class="fas fa-chevron-up ml-2 text-sm"></i>';
        }
    }

    // Toggle menu mobile
    document.getElementById('menu-toggle').addEventListener('click', function() {
        document.querySelector('.sidebar').classList.toggle('active');
        document.querySelector('.main-content').classList.toggle('active');
    });

    // Initialisation
    document.addEventListener('DOMContentLoaded', function() {
        displayAPIs();

        // Permettre la recherche avec la touche Entrée
        document.getElementById('searchInput').addEventListener('keypress', function(e) {
            if (e.key === 'Enter') {
                searchAPIs();
            }
        });
    });