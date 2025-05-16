document.addEventListener('DOMContentLoaded', function() {
     // Profile picture upload preview
     const profileInput = document.getElementById('profilePicture');
     const previewContainer = document.getElementById('previewContainer');
     const profilePreview = document.getElementById('profilePreview');
     const defaultPreview = document.getElementById('defaultPreview');

     profileInput.addEventListener('change', function() {
         const file = this.files[0];
         const profileErrorText = document.getElementById('profile-error-text');

         if (file) {
             // File type validation
             if (!file.type.match('image.*')) {
                 profileErrorText.textContent = 'Seules les images sont autorisées';
                 profileErrorText.classList.remove('hidden');
                 return;
             }

             // File size validation (2MB max)
             if (file.size > 2 * 1024 * 1024) {
                 profileErrorText.textContent = 'La taille maximale est de 2MB';
                 profileErrorText.classList.remove('hidden');
                 return;
             }

             profileErrorText.classList.add('hidden');

             const reader = new FileReader();
             reader.onload = function(e) {
                 profilePreview.src = e.target.result;
                 profilePreview.classList.remove('hidden');
                 defaultPreview.classList.add('hidden');
                 previewContainer.classList.remove('border-dashed');
                 previewContainer.classList.add('border-solid', 'border-indigo-300');
             }
             reader.readAsDataURL(file);
         }
     });

     // Password toggle visibility
     const togglePassword = document.getElementById('togglePassword');
     const passwordInput = document.getElementById('password');

     togglePassword.addEventListener('click', function() {
         const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
         passwordInput.setAttribute('type', type);
         this.innerHTML = type === 'password' ? '<i class="fas fa-eye"></i>' : '<i class="fas fa-eye-slash"></i>';
     });

     // Password strength indicator
     passwordInput.addEventListener('input', function() {
         const strengthBar = document.getElementById('password-strength');
         strengthBar.classList.remove('hidden');

         const password = this.value;
         let strength = 0;

         // Length check
         if (password.length > 0) strength++;
         if (password.length >= 8) strength++;

         // Complexity checks
         if (password.match(/[A-Z]/)) strength++;
         if (password.match(/[0-9]/)) strength++;
         if (password.match(/[^A-Za-z0-9]/)) strength++;

         // Cap strength at 4 for our 4 bars
         strength = Math.min(strength, 4);

         // Update strength bars
         const strengthText = document.getElementById('strength-text');
         const strengthColors = ['bg-red-500', 'bg-yellow-500', 'bg-blue-500', 'bg-green-500'];
         const strengthMessages = ['Très faible', 'Faible', 'Moyen', 'Fort'];

         for (let i = 1; i <= 4; i++) {
             const bar = document.getElementById(`strength-${i}`);
             if (i <= strength) {
                 bar.classList.remove('bg-gray-200');
                 bar.classList.add(strengthColors[strength-1]);
             } else {
                 bar.classList.remove('bg-red-500', 'bg-yellow-500', 'bg-blue-500', 'bg-green-500');
                 bar.classList.add('bg-gray-200');
             }
         }

         if (password.length > 0) {
             strengthText.textContent = `Force du mot de passe: ${strengthMessages[strength-1] || 'Très faible'}`;
         } else {
             strengthText.textContent = '';
         }
     });

     // Form validation and submission
     const form = document.getElementById('registerForm');
     form.addEventListener('submit', function(e) {
         e.preventDefault(); // Prevent default submission
         let isValid = true;

         // Validate full name
         const fullname = document.getElementById('fullname');
         const fullnameError = document.getElementById('fullname-error');
         const fullnameErrorText = document.getElementById('fullname-error-text');

         if (fullname.value.trim() === '') {
             fullnameError.classList.remove('hidden');
             fullnameErrorText.textContent = 'Le nom complet est requis';
             fullnameErrorText.classList.remove('hidden');
             isValid = false;
         } else {
             fullnameError.classList.add('hidden');
             fullnameErrorText.classList.add('hidden');
         }

         // Validate email
         const email = document.getElementById('email');
         const emailError = document.getElementById('email-error');
         const emailErrorText = document.getElementById('email-error-text');
         const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

         if (email.value.trim() === '') {
             emailError.classList.remove('hidden');
             emailErrorText.textContent = 'L\'email est requis';
             emailErrorText.classList.remove('hidden');
             isValid = false;
         } else if (!emailRegex.test(email.value)) {
             emailError.classList.remove('hidden');
             emailErrorText.textContent = 'Veuillez entrer un email valide';
             emailErrorText.classList.remove('hidden');
             isValid = false;
         } else {
             emailError.classList.add('hidden');
             emailErrorText.classList.add('hidden');
         }

         // Validate password
         const password = document.getElementById('password');
         const passwordError = document.getElementById('password-error');
         const passwordErrorText = document.getElementById('password-error-text');

         if (password.value.trim() === '') {
             passwordError.classList.remove('hidden');
             passwordErrorText.textContent = 'Le mot de passe est requis';
             passwordErrorText.classList.remove('hidden');
             isValid = false;
         } else if (password.value.length < 8) {
             passwordError.classList.remove('hidden');
             passwordErrorText.textContent = 'Le mot de passe doit contenir au moins 8 caractères';
             passwordErrorText.classList.remove('hidden');
             isValid = false;
         } else {
             passwordError.classList.add('hidden');
             passwordErrorText.classList.add('hidden');
         }

         // Validate terms
         const terms = document.getElementById('terms');
         const termsErrorText = document.getElementById('terms-error-text');

         if (!terms.checked) {
             termsErrorText.classList.remove('hidden');
             isValid = false;
         } else {
             termsErrorText.classList.add('hidden');
         }

         // If valid, submit the form
         if (isValid) {
             form.submit(); // Submit the form if all validations pass
         }
     });
 });