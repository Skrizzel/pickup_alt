import Paper from '@mui/material/Paper';
import InputBase from '@mui/material/InputBase';
import IconButton from '@mui/material/IconButton';
import SearchIcon from '@mui/icons-material/Search';

type SearchProps = {
  placeholder: string;
};

export default function Searchbar(props: SearchProps) {
  return (
    <Paper
      component="form"
      sx={{
        p: '2px 4px',
        display: 'flex',
        alignItems: 'center',
      }}
    >
      <InputBase
        sx={{ml: 1, flex: 1}}
        placeholder={props.placeholder}
        // inputProps={{'aria-label': 'search google maps'}}
      />
      <IconButton type="button" sx={{p: '10px'}} aria-label="search">
        <SearchIcon />
      </IconButton>
    </Paper>
  );
}
