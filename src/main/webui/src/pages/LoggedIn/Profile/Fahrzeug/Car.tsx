import Avatar from '@mui/material/Avatar';
import ToTopLayout from '../../../Layout/ToTopLayout';
import List from '@mui/material/List';
import Container from '@mui/material/Container';
import ListItem from '@mui/material/ListItem';
import TextField from '@mui/material/TextField';
import IconButton from '@mui/material/IconButton';
import EditIcon from '@mui/icons-material/Edit';
import {listItemStyle, styleForListItemContainer} from '../../../../shared/styles';
import {useState} from 'react';

type CarProps = {
  Autoname: string;
  Kennzeichen: string;
  Beschreibung: string;
  Basispreis: number;
  Kilometerpreis: number;
};

const Car = () => {
  const autoData = {
    Auto: 'Subaru Etwas',
    Kennzeichen: '',
    Beschreibung: '',
    Basispreis: '',
    Kilometerpreis: '',
  };
  const sizeOfAvatar = '100px';

  // State to track the editable status for each field
  const [editStatus, setEditStatus] = useState(
    Object.keys(autoData).reduce((acc: Record<string, boolean>, key) => {
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
        {Object.entries(autoData).map(([key, val], index) => (
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
      </List>
    </ToTopLayout>
  );
};
export default Car;
