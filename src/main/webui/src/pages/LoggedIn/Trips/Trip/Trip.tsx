import ToTopLayout from '../../../Layout/ToTopLayout';
import TripCard from '../TripCard';
import Map, {Source, Layer} from 'react-map-gl/maplibre';
import {routeGeoJson} from './testGeoData';
import {useLoaderData} from 'react-router-dom';
import {TestUserType} from '../Trips';

const Trip = () => {
  // Create GeoJSON data for the route
  const user = useLoaderData() as TestUserType;

  return (
    <ToTopLayout>
      <TripCard date={new Date()} nameOfDriver={user.name} from={user.address.city} to={user.address.street} />
      {/* <iframe src="http://192.168.100.100:8080/" style={{width: '100%', aspectRatio: '3/2', alignSelf: 'center', marginTop: '1rem'}}></iframe> */}
      <Map
        initialViewState={{
          longitude: 8.681445,
          latitude: 49.41461,
          zoom: 15,
        }}
        style={{width: '100%', aspectRatio: '3/2', alignSelf: 'center', marginTop: '1rem'}}
        mapStyle="https://tiles.openfreemap.org/styles/liberty"
      >
        <Source id="route" type="geojson" data={routeGeoJson}>
          <Layer
            id="route-line"
            type="line"
            source="route"
            paint={{
              'line-color': '#3b9ddd',
              'line-width': 5,
            }}
            layout={{
              'line-join': 'round',
              'line-cap': 'round',
            }}
          />
        </Source>
      </Map>
    </ToTopLayout>
  );
};
export default Trip;
