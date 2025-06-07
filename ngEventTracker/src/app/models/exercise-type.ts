import { Exercise } from "./exercise";

export class ExerciseType {
  id: number;
  name: string;
  description: string;
  imageURL: string;
  teamSport: boolean;


  constructor(
  id: number = 0,
  name: string = "",
  description: string = "",
  imageURL: string = "",
  teamSport: boolean = false,

  ){
    this.id = id;
    this.name = name;
    this.description = description;
    this.imageURL = imageURL;
    this.teamSport = teamSport;

  }
}
