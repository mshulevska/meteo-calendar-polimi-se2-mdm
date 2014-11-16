open util/boolean

//Signatures

sig User {
	calendar : one Calendar
}

sig Location {}

sig Event {
	location : one Location	,
	public : one Bool
}

sig Calendar {
	events : set Event
}

sig Invitation {
	fromEvent : one Event,
	invited : set User
}

//Functions

fun organizer (e : Event) : set User { e [Calendar<:events] [User<:calendar] }


fun invitedPeople (e : Event) : set User { ((Invitation<:fromEvent).e).(Invitation<:invited) }

fun whichEvent (i : Invitation) : one Event { i [~(Invitation<:fromEvent)] }


//Facts

fact noEmptyInvitation {
	all i : Invitation | i in (Invitation<:fromEvent).Event and i in (Invitation<:invited).User
}

fact noTwoInvitationForSameEvent {
		//not two different invitations to the same user from the same event
		no disj i1, i2 : Invitation | i1.(Invitation<:fromEvent) != i2.(Invitation<:fromEvent)
}

fact organizerCannotInviteHimself {
   no i : Invitation | let e = whichEvent[i] | organizer[e] in invitedPeople[e]
}


fact oneCalendarPerUser {
    //each user can have at most one calendar
	all disj c1, c2 : Calendar | (c1 [User<:calendar] & c2 [User<:calendar] ) = none
	#Calendar = #User
	all c : Calendar | 	c in User.(User<:calendar)
}

fact eachEventMustHaveCalendar {
	//each event pust be associated with a calendar
	all e : Event | e [Calendar<:events] != none
}


fact eventCanBePublicOrPrivate {
	//event can be public or private but not both
	all e1, e2 : Event | e1 = e2 implies  e1.(Event<:public) = e2.(Event<:public)
}


//Assertions

assert eventCannotHaveTwoCalendars{
	//event cannot be created from multiple calendars
	//no c1, c2 : Calendar | (c1.events & c2.events) != none implies c1
}

//check eventCannotHaveTwoCalendars

assert organizerHasNotSelfInvited {
	no i: Invitation | organizer[whichEvent[i]] = i.(Invitation<:invited)
}


check organizerHasNotSelfInvited


//Predicates

pred showAll {}

pred show{
	#Event > #Calendar
	#Location <= #Calendar
}

pred showInvitations {
	#Event = 1
	#User = 3
	#Location = 1
}

run showInvitations for 5

pred controlUsers {
	#User = 5
}

run controlUsers for 5 but 1 Event
run show for 10
run showAll for 5
run show for 5 but 4 Invitation
