import {useState} from 'react';
import Avatar from '@mui/material/Avatar';
import ToTopLayout from '../../Layout/ToTopLayout';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import AddIcon from '@mui/icons-material/Add';
import EditIcon from '@mui/icons-material/Edit';
import Container from '@mui/material/Container';
import {listItemStyle, styleForListItemContainer} from '../../../shared/styles';
import TextField from '@mui/material/TextField';
import {IconButton} from '@mui/material';
import {NavLink} from 'react-router-dom';

const Profile = () => {
  const tesSettings = {
    Nutzername: 'Max Mustermann',
    'E-mail': 'Max.Mustermann@bube.com',
    Passwort: '********',
    Fahrzeug: 'Subaru Legacy',
  };

  const sizeOfAvatar = '100px';

  // State to track the editable status for each field
  const [editStatus, setEditStatus] = useState(
    Object.keys(tesSettings).reduce((acc: Record<string, boolean>, key) => {
      acc[key] = true; // Initially, all fields are disabled
      return acc;
    }, {})
  );

  const onEdit = (key: string) => {
    setEditStatus((prevStatus) => ({
      ...prevStatus,
      [key]: !prevStatus[key], // Toggle the edit state for the specific field
    }));
  };

  return (
    <ToTopLayout>
      <div style={{width: '100%', display: 'flex', justifyContent: 'center'}}>
        <Avatar sx={{height: sizeOfAvatar, width: sizeOfAvatar}}>Me</Avatar>
      </div>
      <List sx={{paddingTop: '0px', marginTop: '1rem'}}>
        {Object.entries(tesSettings).map(([key, val], index) => (
          <Container sx={styleForListItemContainer} key={index}>
            <ListItem sx={listItemStyle}>
              <TextField
                disabled={editStatus[key]} // Control the disabled state per field
                id={`field-${key}`}
                defaultValue={val}
                label={key}
                variant="standard"
              />
            </ListItem>
            <IconButton onClick={() => onEdit(key)} aria-label={`edit-${key}`} sx={{padding: 0}}>
              <EditIcon />
            </IconButton>
          </Container>
        ))}
        <Container sx={styleForListItemContainer}>
          <ListItem sx={listItemStyle}>
            <p>Fahrzeug erstellen</p>
          </ListItem>
          <NavLink to={'/user/car'} style={{display: 'flex'}}>
            <AddIcon sx={{display: 'flex', alignSelf: 'center'}} />
          </NavLink>
        </Container>
      </List>
    </ToTopLayout>
  );
};

export default Profile;
