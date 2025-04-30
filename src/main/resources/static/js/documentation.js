   // Chart for requests activity
        const ctx = document.getElementById('requestsChart').getContext('2d');
        const requestsChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ['Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam', 'Dim'],
                datasets: [
                    {
                        label: 'Requêtes réussies',
                        data: [1200, 1900, 1700, 2100, 2300, 1500, 1800],
                        backgroundColor: 'rgba(16, 185, 129, 0.1)',
                        borderColor: '#10B981',
                        borderWidth: 2,
                        tension: 0.3,
                        fill: true
                    },
                    {
                        label: 'Requêtes en erreur',
                        data: [30, 45, 60, 25, 40, 20, 35],
                        backgroundColor: 'rgba(239, 68, 68, 0.1)',
                        borderColor: '#EF4444',
                        borderWidth: 2,
                        tension: 0.3,
                        fill: true
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    tooltip: {
                        mode: 'index',
                        intersect: false,
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });

        // Toggle mobile menu
        document.querySelector('.md\\:hidden').addEventListener('click', function() {
            document.querySelector('.md\\:flex').classList.toggle('hidden');
        });

        // Simulate API status updates
        function updateApiStatus() {
            const statuses = document.querySelectorAll('[class*="status-"]');
            statuses.forEach(status => {
                // Randomly change status for demo purposes
                if (Math.random() > 0.8) {
                    const currentClass = Array.from(status.classList).find(cls => cls.startsWith('status-'));
                    if (currentClass) {
                        status.classList.remove(currentClass);
                        const statusTypes = ['status-active', 'status-warning', 'status-error', 'status-maintenance'];
                        const newStatus = statusTypes[Math.floor(Math.random() * statusTypes.length)];
                        status.classList.add(newStatus);

                        // Update the status text
                        const statusTextMap = {
                            'status-active': 'Active',
                            'status-warning': 'Instable',
                            'status-error': 'Erreur',
                            'status-maintenance': 'Maintenance'
                        };
                        const statusTextElement = status.parentElement;
                        if (statusTextElement) {
                            statusTextElement.textContent = statusTextMap[newStatus];
                            // Update the background color class
                            const bgClasses = ['bg-green-100', 'bg-yellow-100', 'bg-red-100', 'bg-gray-100'];
                            const textClasses = ['text-green-800', 'text-yellow-800', 'text-red-800', 'text-gray-800'];
                            statusTextElement.classList.remove(...bgClasses, ...textClasses);

                            if (newStatus === 'status-active') {
                                statusTextElement.classList.add('bg-green-100', 'text-green-800');
                            } else if (newStatus === 'status-warning') {
                                statusTextElement.classList.add('bg-yellow-100', 'text-yellow-800');
                            } else if (newStatus === 'status-error') {
                                statusTextElement.classList.add('bg-red-100', 'text-red-800');
                            } else {
                                statusTextElement.classList.add('bg-gray-100', 'text-gray-800');
                            }
                        }
                    }
                }
            });
        }

        // Update status every 10 seconds for demo
        setInterval(updateApiStatus, 10000);