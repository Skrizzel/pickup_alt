// test func
export function getRandomDate() {
  return new Date(new Date(2001, 0, 1).getTime() + Math.random() * (new Date().getTime() - new Date(2001, 0, 1).getTime()));
}
