import ToTopLayout from '../../../Layout/ToTopLayout';
import TripCard from '../TripCard';
import Map, {Source, Layer} from 'react-map-gl/maplibre';
// import {etwas, routeGeoJson} from './testGeoData';
import {useLoaderData} from 'react-router-dom';
import {TestUserType} from '../Trips';
import {useQuery} from '@tanstack/react-query';

const ROUTING_URL = 'http://10.1.0.248:8080/routes';

type GeoJson = {
  coordinates: [number, number][];
  type: string;
};

const Trip = () => {
  const user = useLoaderData() as TestUserType;

  // Create GeoJSON data for the route
  // const testCords = '8.681495,49.41461;8.687872,49.420318?overview=full&steps=true&geometries=geojson';

  const geoJson = useQuery({
    queryKey: ['geoJson'],
    queryFn: () =>
      fetch(ROUTING_URL)
        .then((res) => res.json())
        .then((res) => {
          console.log(res);

          return res as GeoJson;
        })
        .catch((e) => {
          throw new Error(e);
        }),
  });

  return (
    <ToTopLayout>
      <TripCard date={new Date()} nameOfDriver={user.name} from={user.address.city} to={user.address.street} />
      <Map
        initialViewState={{
          longitude: 8.681495,
          latitude: 49.41461,
          zoom: 15,
        }}
        style={{width: '100%', aspectRatio: '3/2', alignSelf: 'center', marginTop: '1rem'}}
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
        {geoJson.isError ? (
          <div>Error: {geoJson.error.message}</div>
        ) : (
          geoJson.isSuccess && (
            <Source id="route" type="geojson" data={geoJson.data}>
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
          )
        )}
      </Map>
    </ToTopLayout>
  );
};
export default Trip;
