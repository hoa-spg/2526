# CSS Learning Project - Wiener Sportclub
## Progressive CSS-Ausbaustufen

Dieses Projekt demonstriert die schrittweise Entwicklung einer Website mit progressivem CSS-Enhancement. Jede Version baut auf der vorherigen auf und führt neue CSS-Konzepte ein.

---

## Version 0: Gar kein CSS
**Thema:** Reines HTML ohne Styling

**Features:**
- Ungestyltes HTML
- Browser-Standard-Darstellung
- Zeigt die Grundstruktur der Webseite

**Lernziele:**
- HTML-Semantik verstehen
- Bedeutung von CSS erkennen

---

## Version 1: CSS Grundlagen
**Thema:** Fundamentale CSS-Konzepte (vereinfacht)

**Neue CSS-Themen:**
- CSS Reset (`* { box-sizing: border-box }`)
- Typografie und Schriftarten
- Farben und Hintergründe
- Box-Model (margin, padding, border)
- Einfache Selektoren (Element, Klasse, ID)
- Hover-Effekte
- Float-Layout

**Neue Features:**
- Grundlegende Farbgestaltung
- Einfache Schriftarten (Arial)
- Header mit Float-Layout
- Formulare und Tabellen
- Responsive Grundlagen (max-width)
- Vereinfachte Selektoren (weniger komplexe Kombinationen)

**Besonderheiten:**
- Bewusst einfach gehalten für Lernzwecke
- Keine komplexen visuellen Effekte
- Fokus auf CSS-Grundlagen

---

## Version 2: Visuelle Verbesserungen
**Thema:** CSS @import und erweiterte Gestaltung

**Neue CSS-Themen:**
- `@import` zum Laden anderer CSS-Dateien
- Pseudo-Selektoren (`:nth-child()`, `:hover`)
- Erweiterte Typografie
- Gradient-Hintergründe
- Box-Shadow Effekte
- Zebra-Streifen in Tabellen

**Neue Features:**
- Verbesserte Schriftart (Segoe UI)
- Gradient-Header und H1-Styling
- Schatten-Effekte auf Sections und Tabellen
- Erweiterte Tabellen-Gestaltung
- Focus-Effekte mit Schatten
- Placeholder-Styling

**Aufbau auf V1:**
- Importiert alle V1-Styles
- Fügt visuelle Verbesserungen hinzu
- Zeigt Unterschied zwischen funktionalem und schönem CSS

---

## Version 3: Flexbox Layout
**Thema:** Moderne Layout-Techniken mit Flexbox

**Neue CSS-Themen:**
- `display: flex`
- Flexbox-Properties (gap, flex-wrap, justify-content)
- Flex-Items (flex, order)
- Modern Layout-Prinzipien

**Neue Features:**
- Header-Layout mit Flexbox
- Navigation als flexibles Grid
- Section-Cards mit Flexbox-Layout
- Bildpositionierung mit `order: -1`
- Responsive Card-Grid
- Clearfix-Entfernung (nicht mehr nötig)

**Flexbox-Anwendungen:**
- `.sections-grid` mit `flex-wrap`
- `.section-card` mit `flex-direction: column`
- Navigation mit `gap` und `justify-content`

---

## Version 4: Responsive Design & CSS Grid
**Thema:** Mobile-First Design und CSS Grid

**Neue CSS-Themen:**
- Media Queries (`@media`)
- CSS Grid Layout
- Grid Template Areas
- Sticky Positioning
- Mobile Navigation (Hamburger Menu)
- Responsive Breakpoints

**Neue Features:**
- Sticky Navigation Header
- Mobile Hamburger-Menü (CSS-only)
- Desktop: CSS Grid für Sidebar-Layout
- Mobile: Stack-Layout für alle Inhalte
- Responsive Aside-Positionierung
- Grid Template Areas für Layout-Kontrolle

**Mobile Features:**
- Hamburger-Icon mit CSS
- Checkbox-Toggle für Navigation
- Responsive Aside-Verstecken
- 800px Breakpoint für Desktop/Mobile

**Grid-Layout:**
```css
grid-template-areas: 
  "sektionen sektionen"
  "sektionen aside";
```

---

## Version 5: Animationen & Transitions
**Thema:** CSS-Animationen und Übergangseffekte

**Neue CSS-Themen:**
- CSS Custom Properties (Variablen) für Animation-Timing
- `@keyframes` für komplexe Animationen
- `transition` für sanfte Übergänge
- `transform` für Bewegungen
- Animation-Performance mit `will-change`

**Neue Features:**
- Page-Load Animation
- Hover-Animationen für Cards
- Button-Transform-Effekte
- Smooth-Scroll Verhalten
- Verschiedene Easing-Functions
- Mobile-optimierte Animationen

**Animation-Variablen:**
```css
--transition-fast: 0.2s ease-out;
--transition-normal: 0.3s ease-out;
--bounce: cubic-bezier(0.68, -0.55, 0.265, 1.55);
```

**Besonderheiten:**
- Mobile Navigation Animationen entfernt (Klick-Probleme vermieden)
- Performance-Optimierungen
- Sanfte Hover-Effekte ohne Überlappungen

---

## Version 6: Dark/Light Mode Theming
**Thema:** CSS Custom Properties und Theme-System

**Neue CSS-Themen:**
- CSS Custom Properties (CSS-Variablen)
- `[data-theme]` Attribut-Selektoren
- Theming-Strategien
- JavaScript-CSS Integration
- Theme-Persistierung (localStorage)

**Neue Features:**
- Vollständiges Dark/Light Mode System
- Theme-Toggle Button
- Theme-Persistierung beim Reload
- Umfassende Komponenten-Theming
- Smooth Theme-Transitions

**Theme-System:**
- Light Theme: Nutzt ursprüngliche V1-V5 Styles
- Dark Theme: Überschreibt mit CSS Custom Properties
- Alle Komponenten unterstützt (Header, Cards, Tables, Forms)

**Theming-Bereiche:**
- Hauptfarben und Akzentfarben
- Hintergrundfarben (primär, sekundär, tertiär)
- Textfarben für verschiedene Kontraste
- Form-Elemente und Buttons
- Navigation und Footer

**JavaScript-Integration:**
- Theme-Toggle Funktionalität
- localStorage für Persistierung
- Smooth Transition-Klassen