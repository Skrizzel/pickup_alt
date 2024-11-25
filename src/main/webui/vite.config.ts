import {defineConfig} from 'vite';
import react from '@vitejs/plugin-react';
import {VitePWA} from 'vite-plugin-pwa';

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        react(),
        VitePWA({
            registerType: 'autoUpdate',
            devOptions: {
                enabled: true,
            },
            workbox: {
                globPatterns: ['**/*.{js,css,html,ico,png,svg}'],
            },
            outDir: 'dist',
            manifest: {
                name: 'PickUp',
                orientation: 'any',
                short_name: 'PickUp',
                start_url: '/',
                display: 'standalone',
                description: 'Search for Mitfahrer!',
                theme_color: '#ffffff',
                background_color: '#000000',
                icons: [
                    {
                        src: '/icons/favicon-48x48.png',
                        sizes: '48x48',
                        type: 'img/png',
                        purpose: 'any',
                    },
                    {
                        src: '/icons/web-app-manifest-192x192.png',
                        sizes: '192x192',
                        type: 'img/png',
                        purpose: 'any',
                    },
                    {
                        src: '/icons/web-app-manifest-512x512.png',
                        sizes: '512x512',
                        type: 'img/png',
                        purpose: 'any',
                    },
                ],
            },
        }),
    ],
});
