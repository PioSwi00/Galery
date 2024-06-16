document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('gallery-form');
    const formError = document.getElementById('form-error');
    const galleriesList = document.getElementById('galleries');
    const loadGalleriesButton = document.getElementById('load-galleries');

    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        const name = form.name.value.trim();
        const location = form.location.value.trim();

        if (name && location) {
            const response = await fetch('/api/galleries', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ name, location })
            });

            if (response.ok) {
                formError.textContent = '';
                form.reset();
                loadGalleries();
            } else {
                const errorData = await response.json();
                formError.textContent = JSON.stringify(errorData);
            }
        } else {
            formError.textContent = 'Please fill out all fields.';
        }
    });

    loadGalleriesButton.addEventListener('click', loadGalleries);

    async function loadGalleries() {
        const response = await fetch('/api/galleries');
        if (response.ok) {
            const galleries = await response.json();
            galleriesList.innerHTML = '';
            galleries.forEach(gallery => {
                const li = document.createElement('li');
                li.textContent = `${gallery.name} (${gallery.location})`;
                galleriesList.appendChild(li);
            });
        } else {
            galleriesList.innerHTML = 'Failed to load galleries.';
        }
    }
});
