export const routeGeoJson = {
    type: 'FeatureCollection',
    bbox: [8.681445, 49.41461, 8.690123, 49.420514],
    features: [
        {
            bbox: [8.681445, 49.41461, 8.690123, 49.420514],
            type: 'Feature',
            properties: {
                segments: [
                    {
                        distance: 1365.2,
                        duration: 315.2,
                        steps: [
                            {
                                distance: 312.2,
                                duration: 74.9,
                                type: 11,
                                instruction: 'Head north on Wielandtstraße',
                                name: 'Wielandtstraße',
                                way_points: [0, 5],
                            },
                            {
                                distance: 253.2,
                                duration: 60.8,
                                type: 1,
                                instruction: 'Turn right onto Mönchhofstraße',
                                name: 'Mönchhofstraße',
                                way_points: [5, 10],
                            },
                            {
                                distance: 213.2,
                                duration: 51.2,
                                type: 0,
                                instruction: 'Turn left onto Keplerstraße',
                                name: 'Keplerstraße',
                                way_points: [10, 11],
                            },
                            {
                                distance: 372.9,
                                duration: 89.5,
                                type: 1,
                                instruction: 'Turn right onto Moltkestraße',
                                name: 'Moltkestraße',
                                way_points: [11, 15],
                            },
                            {
                                distance: 83.0,
                                duration: 7.5,
                                type: 2,
                                instruction: 'Turn sharp left onto Handschuhsheimer Landstraße, B 3',
                                name: 'Handschuhsheimer Landstraße, B 3',
                                way_points: [15, 17],
                            },
                            {
                                distance: 130.6,
                                duration: 31.4,
                                type: 0,
                                instruction: 'Turn left onto Roonstraße',
                                name: 'Roonstraße',
                                way_points: [17, 18],
                            },
                            {
                                distance: 0.0,
                                duration: 0.0,
                                type: 10,
                                instruction: 'Arrive at Roonstraße, straight ahead',
                                name: '-',
                                way_points: [18, 18],
                            },
                        ],
                    },
                ],
                way_points: [0, 18],
                summary: {distance: 1365.2, duration: 315.2},
            },
            geometry: {
                coordinates: [
                    [8.681495, 49.41461],
                    [8.681445, 49.415755],
                    [8.681509, 49.416088],
                    [8.681674, 49.416601],
                    [8.681873, 49.417276],
                    [8.681882, 49.417391],
                    [8.682461, 49.417389],
                    [8.68269, 49.417389],
                    [8.682782, 49.417388],
                    [8.683596, 49.417386],
                    [8.685382, 49.417368],
                    [8.68504, 49.419273],
                    [8.686507, 49.41943],
                    [8.687109, 49.419488],
                    [8.688398, 49.41963],
                    [8.690123, 49.419833],
                    [8.689854, 49.420217],
                    [8.689653, 49.420514],
                    [8.687871, 49.420322],
                ],
                type: 'LineString',
            },
        },
    ],
    metadata: {
        attribution: 'openrouteservice.org, OpenStreetMap contributors, tmc - BASt',
        service: 'routing',
        timestamp: 1730120902535,
        query: {
            coordinates: [
                [8.681495, 49.41461],
                [8.687872, 49.420318],
            ],
            profile: 'driving-car',
            format: 'json',
        },
        engine: {version: '8.2.0', build_date: '2024-10-09T09:23:42Z', graph_date: '2024-10-28T10:15:59Z'},
    },
};
