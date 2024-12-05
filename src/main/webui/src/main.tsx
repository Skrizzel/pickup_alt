import {StrictMode} from 'react';
import {createRoot} from 'react-dom/client';
import {ThemeProvider, createTheme} from '@mui/material/styles';
// import App from './App.tsx';
import './index.scss';
import {LocalizationProvider} from '@mui/x-date-pickers';
import {AdapterDayjs} from '@mui/x-date-pickers/AdapterDayjs';

import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';
import {createBrowserRouter, RouterProvider} from 'react-router-dom';
import ErrorPage from './pages/Error/Error.tsx';
import Trips from './pages/LoggedIn/Trips/Trips.tsx';
import NotFound from './pages/NotFound/NotFound.tsx';
import Login from './pages/Login/Login.tsx';
import Auth from './pages/Auth/Auth.tsx';
import Search from './pages/LoggedIn/Search/Search.tsx';
import Profile from './pages/LoggedIn/Profile/Profile.tsx';
import Chat from './pages/LoggedIn/Chat/Chat.tsx';
import {CssBaseline} from '@mui/material';
import MainLayoutWithFooter from './pages/Layout/MainLayoutWithFooter.tsx';
import {QueryClient, QueryClientProvider} from '@tanstack/react-query';
import Trip from './pages/LoggedIn/Trips/Trip/Trip.tsx';
import {testUsersData} from './shared/testUsersData.ts';
import NewTrip from './pages/LoggedIn/NewTrip/NewTrip.tsx';
import TripSearchBar from './pages/LoggedIn/Trips/TripSearchBar.tsx';
// import {ReactQueryDevtools} from '@tanstack/react-query-devtools';

const router = createBrowserRouter([
  {
    path: '/',
    errorElement: <ErrorPage />,
    // element: <Layout />,
    children: [
      {index: true, element: <Auth />},
      {path: 'auth', element: <Auth />},
      {path: 'login', element: <Login />},
      {
        path: 'user',
        element: <MainLayoutWithFooter />,
        children: [
          {
            path: 'trips',
            element: <TripSearchBar></TripSearchBar>,
            children: [
              {index: true, element: <Trips />},
              {
                path: 'newTrip',
                element: <NewTrip />,
              },
              {
                path: 'search',
                element: <Search />,
              },
            ],
          },
          {path: 'search', element: <Search></Search>},
          {path: 'profile', element: <Profile></Profile>},
          {path: 'chat', element: <Chat></Chat>},
          {
            path: 'trip/:id',
            element: <Trip />,
            loader: async ({params}) => {
              return testUsersData.find((user) => String(user.id) === params.id);
            },
          },
        ],
      },
      {path: '*', element: <NotFound />},
    ],
  },
]);

const darkTheme = createTheme({
  palette: {
    mode: 'dark',
  },
});

const queryClient = new QueryClient();

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <QueryClientProvider client={queryClient}>
      <LocalizationProvider dateAdapter={AdapterDayjs}>
        <ThemeProvider theme={darkTheme}>
          <CssBaseline />
          <RouterProvider router={router} />
          {/* <ReactQueryDevtools/> */}
        </ThemeProvider>
      </LocalizationProvider>
    </QueryClientProvider>
  </StrictMode>
);
