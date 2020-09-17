import {Show} from './show'
import { Movie } from "./movie";
export class Booking
{
    bookingId:string;
    bookingDate:Date;
    noOfTkts:number;
    totalCost:DoubleRange;
    userName:string;
    show:Show=new Show();
    contact:string;
}