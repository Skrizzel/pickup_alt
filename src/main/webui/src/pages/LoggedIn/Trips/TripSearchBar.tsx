import {Link, Outlet, useLocation} from 'react-router-dom';
import SearchBar from '../../../components/SearchBar/SearchBar';
import {Box} from '@mui/material';

const TripSearchBar = () => {
  const location = useLocation().pathname.split('/').pop();
  const isCurrentLocationTrips = location == 'trips';

  return (
    <>
      <Box sx={{marginBottom: '1rem'}}>
        <Link to="search">
          <SearchBar
            placeholder={isCurrentLocationTrips ? 'Fahrt suchen' : 'Startadresse'}
            readOnly={isCurrentLocationTrips ? true : false}
          ></SearchBar>
        </Link>
      </Box>
      <Outlet />
    </>
  );
};
export default TripSearchBar;
