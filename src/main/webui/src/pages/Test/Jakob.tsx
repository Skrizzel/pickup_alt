import Map, {Source, Layer} from 'react-map-gl/maplibre';
import {useState, useEffect} from 'react';
import {Button, Box, TextField} from '@mui/material';

type GeoJson = {
  coordinates: [number, number][];
  type: string;
};

const Jakob = () => {
  const [urlInput, setUrlInput] = useState(''); // Captures the user input in TextField
  const [routingUrl, setRoutingUrl] = useState(''); // Stores the current URL to fetch route
  const [routingData, setRoutingData] = useState<GeoJson | null>(null); // Holds the GeoJSON data

  // Fetch route data when routingUrl changes
  useEffect(() => {
    if (routingUrl) {
      getRoute(routingUrl).then((data) => {
        if (data) setRoutingData(data);
      });
    }
  }, [routingUrl]);

  return (
    <Box sx={{display: 'flex', width: '100%'}}>
      <Box sx={{display: 'flex'}}>
        <Map
          initialViewState={{
            longitude: 8.681495,
            latitude: 49.41461,
            zoom: 15,
          }}
          style={{
            width: '100%',
            aspectRatio: '3/2',
            alignSelf: 'center',
            marginTop: '1rem',
            marginBottom: '3rem',
          }}
          mapStyle={{
            version: 8,
            sources: {
              'raster-tiles': {
                type: 'raster',
                tiles: ['https://tiles.jackinatox.com/tile/{z}/{x}/{y}.png'],
                tileSize: 256,
              },
            },
            layers: [
              {
                id: 'raster-layer',
                type: 'raster',
                source: 'raster-tiles',
                paint: {},
              },
            ],
          }}
        >
          {/* Show the route if routingData exists */}
          {routingData && (
            <Source id="route" type="geojson" data={routingData}>
              <Layer
                id="route-line"
                type="line"
                source="route"
                paint={{
                  'line-color': '#f03f0d',
                  'line-width': 6,
                }}
                layout={{
                  'line-join': 'round',
                  'line-cap': 'round',
                }}
              />
            </Source>
          )}
        </Map>
      </Box>
      <Box>
        {/* TextField to enter URL */}
        <TextField label="Enter routing URL" value={urlInput} onChange={(e) => setUrlInput(e.target.value)} fullWidth margin="normal" />

        {/* Button to set routingUrl */}
        <Button variant="contained" color="primary" onClick={() => setRoutingUrl(urlInput)}>
          Set
        </Button>
      </Box>
    </Box>
  );
};

export default Jakob;

// Function to fetch GeoJSON route
async function getRoute(url: string): Promise<GeoJson | null> {
  try {
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error(`Response status: ${response.status}`);
    }

    const json = await response.json();
    return json as GeoJson;
  } catch (error) {
    console.error('Failed to fetch route:', error.message);
    return null;
  }
}
