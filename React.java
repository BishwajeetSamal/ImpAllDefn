											 React
											 -----
1.A JavaScript library for building user interfaces
Open source library for building user interfaces.	
Not a framework.
Focuses on UI
Rich ecosystem. 
Component Based Architechture
Reusable code and Component
React is declarative because we write the code that we want.
React is in charge of taking our declared code and performing all of the JavaScript/DOM 
steps to get us to our desired result.  

-------------------------------------------------------------------------------------------------------------------
Note- Declarative programming is a programming paradigm … that expresses the logic of a computation without
 describing its control flow. Imperative programming is a programming paradigm that uses statements that change
  a programs state.
-------------------------------------------------------------------------------------------------------------------
React will handle efficiently updating and rendering the components.
DOM updates and handles gracefully in react.
Seamlessly integrate react into any of your applications.

Create React App
----------------
Create React App is a comfortable environment for learning React, and is the best way to start building a new single-page application in React.
------------------------------
npx create-react-app my-app   |
cd my-app					  |
npm StackTraceElement         |
------------------------------

PROPS--
-----
1. Props stand for "Properties." They are read-only components. 
2. It is an object which stores the value of attributes of a tag and work similar to the HTML attributes.
3.It gives a way to pass data from one component to other components. It is similar to function arguments.


<Greet name="Bishwajeet Samal" />
To access the name we use 

const Greet = (props) => <h1>Hello TestUser </h1>
<p>{props.name}</p> //This will print name

What Is 'State' in ReactJS? 
---------------------------
1. The state is a built-in React object that is used to contain data or information about the component. 
2. A components state can change over time; whenever it changes, the component re-renders.

props vs state
---------------
1. props get passed to the component whereas state is managed within the component.
2.Function parameters whereas in state (variables declared in the function body).
3.Because parent usually passes down to the props thatswhy props are immutable whereas state is mutable or changable.
4. props in class component is accessed by (this.props) and in functional component by (props) whereas state on the other
hand accessed using the useState hook in Functional components and this.state in class compomnent.


In class component
--------------------
constructor(){
	super();
	this.state = {
		message:"Welcome Visitor"
	}
}

to access message value state//
render(){
	return <h1>{this.state.message}</h1>
}


Lifecycle Methods
------------------
1. Mounting -- When an instance of a component is being created and inserted into the DOM.
2. Updating---When a component is being re-rendered as a result of changes to either its props or state.
3. Unmounting --When a component is being removed from the DOM.
4. Error Handling -- When there is an error.

