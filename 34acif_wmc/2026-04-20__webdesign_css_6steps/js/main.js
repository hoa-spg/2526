// External JS extracted from index.html
// Ensures global functions work with inline event handlers

(function () {
  // Newsletter Form Handler
  document.addEventListener('DOMContentLoaded', function () {
    const btn = document.querySelector('.submit-btn');
    if (btn) {
      btn.addEventListener('click', function (e) {
        e.preventDefault();
        const nameEl = document.getElementById('newslname');
        const emailEl = document.getElementById('email');
        const checkEl = document.getElementById('check');

        const name = nameEl ? nameEl.value : '';
        const email = emailEl ? emailEl.value : '';
        const isChecked = checkEl ? checkEl.checked : false;

        if (name && email && isChecked) {
          alert(name + ' erfolgreich für den Newsletter angemeldet!');
          const form = document.querySelector('.newsletter-form');
          if (form) form.reset();
        } else {
          alert('Bitte füllen Sie alle Felder aus und bestätigen Sie, dass Sie kein Roboter sind.');
        }
      });
    }
  });

  // CSS Version Switcher (global for inline handler)
  window.switchCSS = function () {
    const versionSelect = document.getElementById('cssVersion');
    const version = versionSelect ? versionSelect.value : '1';
    const linkElement = document.getElementById('cssLink');

    if (!linkElement) return;

    if (version === '0') {
      // Gar kein CSS - entferne das CSS
      linkElement.href = '';
      linkElement.disabled = true;
    } else {
      // CSS Version laden
      linkElement.href = 'css/css_v' + version + '.css';
      linkElement.disabled = false;
    }
  };

  // Theme Toggle Function (global for inline handler)
  window.toggleTheme = function () {
    const htmlElement = document.documentElement;
    const currentTheme = htmlElement.getAttribute('data-theme');
    const newTheme = currentTheme === 'dark' ? 'light' : 'dark';

    htmlElement.setAttribute('data-theme', newTheme);
    localStorage.setItem('theme', newTheme);

    // Add transition class for smooth theme switching
    document.body.classList.add('theme-transition');
    setTimeout(function () {
      document.body.classList.remove('theme-transition');
    }, 500);
  };

  // Initialize Theme and CSS Version on Page Load
  document.addEventListener('DOMContentLoaded', function () {
    // Theme
    const savedTheme = localStorage.getItem('theme') || 'light';
    const themeToggle = document.getElementById('themeToggle');
    document.documentElement.setAttribute('data-theme', savedTheme);
    if (themeToggle) themeToggle.checked = savedTheme === 'dark';

    // CSS Version
    const savedVersion = localStorage.getItem('cssVersion') || '1';
    const versionSelect = document.getElementById('cssVersion');
    const linkElement = document.getElementById('cssLink');

    if (versionSelect) versionSelect.value = savedVersion;

    if (linkElement) {
      if (savedVersion === '0') {
        linkElement.disabled = true;
      } else {
        linkElement.disabled = false;
        linkElement.href = 'css/css_v' + savedVersion + '.css';
      }
    }

    if (versionSelect) {
      versionSelect.addEventListener('change', function () {
        localStorage.setItem('cssVersion', this.value);
      });
    }
  });
})();
