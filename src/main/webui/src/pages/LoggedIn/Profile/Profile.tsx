import Avatar from '@mui/material/Avatar/Avatar';
import ToTopLayout from '../../Layout/ToTopLayout';
import List from '@mui/material/List/List';
import ListItem from '@mui/material/ListItem/ListItem';
import AddIcon from '@mui/icons-material/Add';
import EditIcon from '@mui/icons-material/Edit';
import './Profile.scss';
import Container from '@mui/material/Container/Container';
import {styleForListItemContainer} from '../../../shared/styles';

const listItemStyle = {
  display: 'flex',
  alignItems: 'flex-start',
  flexDirection: 'column',
  width: '100%',
  'padding-left': '0px',
  'padding-right': '0px',
};

const Profile = () => {
  const tesSettings = {
    Nutzername: 'Max Mustermann',
    'E-mail': 'Max.Mustermann@bube.com',
    Passwort: '********',
    Fahrzeug: 'Subaru Legacy',
  };
  const sizeOfAvatar = '100px';
  return (
    <ToTopLayout>
      <div style={{width: '100%', display: 'flex', justifyContent: 'center'}}>
        <Avatar sx={{height: sizeOfAvatar, width: sizeOfAvatar}}>Me</Avatar>
      </div>
      <List sx={{paddingTop: '0px', marginTop: '1rem'}}>
        {Object.entries(tesSettings).map(([key, val], num) => (
          <Container sx={styleForListItemContainer}>
            <ListItem sx={listItemStyle} key={num}>
              <p>
                <small>{key}</small>
              </p>
              <p>{val}</p>
            </ListItem>
            <EditIcon sx={{display: 'flex', alignSelf: 'center'}} />
          </Container>
        ))}
        <Container sx={styleForListItemContainer}>
          <ListItem sx={listItemStyle}>
            <p>Fahrzeug hinzufügen</p>
          </ListItem>
          <AddIcon sx={{display: 'flex', alignSelf: 'center'}} />
        </Container>
      </List>
    </ToTopLayout>
  );
};

export default Profile;
