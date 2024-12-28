import {List, ListItem, Paper} from '@mui/material';
import {useQuery} from '@tanstack/react-query';
import {BASE_URL} from '../../../shared/constants';
import ChatCard from './ChatCard';
import LoadingCircle from '../../../components/Loading/LoadingCircle';
import {testUsersData} from '../../../shared/testUsersData';
import {getRandomDate} from '../../../shared/functions';
import {styleForListItemContainer} from '../../../shared/styles';

type TestChatType = {
  userId: number;
  id: number;
  title: string;
  body: string;
};

const Chat = () => {
  const chats = useQuery({
    queryKey: ['posts'],
    queryFn: () =>
      fetch(BASE_URL + '/posts')
        .then((res) => res.json())
        .then((chats) => chats as TestChatType[])
        .then((chats) => chats.map((chat) => ({...chat, date: getRandomDate()}))),
  });

  return chats.isLoading ? (
    <LoadingCircle />
  ) : chats.isError ? (
    <p>{chats.error.message}</p>
  ) : (
    chats.isSuccess && (
      <Paper>
        <List sx={{width: '100%'}}>
          {chats.data.map((chat) => {
            return (
              <ListItem key={chat.id} sx={styleForListItemContainer}>
                <ChatCard lastMessage={chat.body} nameOfUser={testUsersData.find((user) => user.id === chat.userId)!.name}></ChatCard>
              </ListItem>
            );
          })}
        </List>
      </Paper>
    )
  );
};

export default Chat;
