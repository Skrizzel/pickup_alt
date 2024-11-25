import Paper from '@mui/material/Paper';
import './Trips.scss';
import {Button, Divider, List, ListItem} from '@mui/material';
import SearchBar from '../../../components/SearchBar/SearchBar';
import ToBottomLayout from '../../Layout/ToBottomLayout';
import ToTopLayout from '../../Layout/ToTopLayout';
// import {useEffect, useState} from 'react';
import LoadingCircle from '../../../components/Loading/LoadingCircle';
import TripCard, {TripCardProps} from './TripCard';
import {useQuery} from '@tanstack/react-query';
import {Link} from 'react-router-dom';
import {BASE_URL} from '../../../shared/constants';
import {getRandomDate} from '../../../shared/functions';

export type TestUserType = {
  id: string;
  name: string;
  username: string;
  email: string;
  address: {
    street: string;
    suite: string;
    city: string;
    zipcode: string;
    geo: {
      lat: string;
      lng: string;
    };
  };
  phone: string;
  website: string;
  company: {
    name: string;
    catchPhrase: string;
    bs: string;
  };
};

const Trips = () => {
  const testListTrips: TripCardProps[] = [];

  const users = useQuery({
    queryKey: ['users'],
    queryFn: () =>
      fetch(BASE_URL + '/users')
        .then((res) => res.json())
        .then(
          (users) =>
            // const users = val as TestUserType[];

            users as TestUserType[]
        )
        .catch((e) => {
          throw new Error(e);
        }),
  });

  return (
    <>
      <ToTopLayout>
        <div id="trips">
          <SearchBar></SearchBar>
          {users.isLoading ? (
            <LoadingCircle />
          ) : users.isError ? (
            <div>Error: {users.error.message}</div>
          ) : (
            users.isSuccess && (
              <Paper>
                <List>
                  {users.data.map((user, index) => {
                    testListTrips.push({date: getRandomDate(), from: user.address.city, to: user.address.street, nameOfDriver: user.name});
                    return (
                      <div key={index}>
                        <Link to={'/user/trip/' + user.id} style={{color: 'inherit', textDecoration: 'inherit'}}>
                          <ListItem
                            sx={{
                              display: 'flex',
                              alignItems: 'flex-start',
                              flexDirection: 'column',
                              width: '100%',
                            }}
                          >
                            <TripCard date={getRandomDate()} from={user.address.city} to={user.address.street} nameOfDriver={user.name}></TripCard>
                          </ListItem>
                        </Link>
                        {index !== users.data.length - 1 && <Divider />}
                      </div>
                    );
                  })}
                </List>
              </Paper>
            )
          )}
        </div>
      </ToTopLayout>
      <ToBottomLayout>
        <div style={{position: 'fixed', bottom: '70px', right: '24px', zIndex: '999'}}>
          <Button variant="contained" sx={{borderRadius: '50px'}}>
            Fahrt erstellen
          </Button>
        </div>
      </ToBottomLayout>
    </>
  );
};

export default Trips;
