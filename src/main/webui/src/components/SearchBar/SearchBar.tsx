import Paper from '@mui/material/Paper';
import InputBase from '@mui/material/InputBase';
import IconButton from '@mui/material/IconButton';
import SearchIcon from '@mui/icons-material/Search';

type SearchProps = {
  placeholder: string;
  readOnly?: boolean;
  value?: string;
};

export default function Searchbar(props: SearchProps) {
  return (
    <Paper
      sx={{
        p: '2px 4px',
        display: 'flex',
        alignItems: 'center',
      }}
    >
      <InputBase sx={{ml: 1, flex: 1}} placeholder={props.placeholder} readOnly={props.readOnly || false} value={props.value || undefined} />
      <IconButton type="button" sx={{p: '10px'}} aria-label="search">
        <SearchIcon />
      </IconButton>
    </Paper>
  );
}
