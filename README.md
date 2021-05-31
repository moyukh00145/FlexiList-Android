# FlexiList

[![Contributors](https://img.shields.io/github/contributors/moyukh00145/FlexiList-Android)](https://github.com/moyukh00145/FlexiList-Android/graphs/contributors) [![GitHub forks](https://img.shields.io/github/forks/moyukh00145/FlexiList-Android)](https://github.com/moyukh00145/FlexiList-Android/network) [![GitHub issues](https://img.shields.io/github/issues/moyukh00145/FlexiList-Android)](https://github.com/moyukh00145/FlexiList-Android/issues)
[![Dependency](https://img.shields.io/badge/Dependency-updated-brightgreen)](#download) [![GitHub license](https://img.shields.io/github/license/moyukh00145/FlexiList-Android)](https://github.com/moyukh00145/FlexiList-Android/blob/master/LICENSE)

FlexiList is a Simple and Handy tool to create and work with Recycler View or List View. Now create your own recycler view without handeling too much code

## Contents

1. [Description](#description)
1. [Benifit](#How-flexilist-can-help?)
1. [Getting started](#getting-started-with-flexilist)
1. [Built with](#built-with)
1. [Authors](#authors)
1. [License](#license)

## Description

Working with FlexiList any one can concentrate in their project without thinking about how to handle and display their data in a simple continous List with low complexity.

### What's the problem?
Every creative developer face a issue about how to show data set in a recycler view or a continious list ? As to add such a funtionality everyone have to code too much which is time consuming and boring too for just making a view to display data in recycler view. Also they have to encountered with lots of methodes, implimentation and errors.

### How FlexiList can help?
FlixiList provides a very simple code to use the Recycler View for displaying data. It handles all the backend codes of a Recycler View to make it easier to use. It also provides the long clik action and swipe action to get more interactive view in Recycler View with beautiful predefined multiple layout file.

## Getting started with FlexiList
For getting started with FlexiList you need to Download the Jar or add the dependency to your project.

## Download
You can download a jar from GitHub's [release page](https://github.com/moyukh00145/FlexiList-Android/releases)
or use Gradle:
- Add it in your project level build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
- Add it in your app level build.gradle at the dependencies :
```
dependencies {
	        implementation 'com.github.moyukh00145:FlexiList-Android:2.1.2'
	}
```
Or Maven:
```
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
</repositories>

<dependency>
	    <groupId>com.github.moyukh00145</groupId>
	    <artifactId>FlexiList-Android</artifactId>
	    <version>2.1.2</version>
</dependency>
```
## How do I use FlexiList?
Firstly declear a Recycler View into your activity.xml file
```
<androidx.recyclerview.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/recycle"/>
```
Then, Link this Recycler View with activity java file.
```
public class MainActivity extends AppCompatActivity{
 RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycle);
    }
}
```
Then, Initialize the Flexilist instance and pass the require elements.
```
FlexiList flexiList=new FlexiList(MainActivity.this,FlexiList.TWO_TEXT_VIEW_ONE_IMAGE,recyclerView);
```
Here you can pass four type of constant for four types of layout to show your data
```
FlexiList.ONE_TEXT_VIEW ( For layout with only one Text View).
FlexiList.TWO_TEXT_VIEW ( For layout with Two Text View).
FlexiList.ONE_TEXT_VIEW_ONE_IMAGE ( For layout with one Text View and one Image View).
FlexiList.TWO_TEXT_VIEW_ONE_IMAGE ( For layout with two Text View and one Image View).
```
Now, add data to the layout you have selected previously by selecting the constants.
```
//Declear Arraylist of Type Object.
    ArrayList<Object>TextView1_data;
    ArrayList<Object>TextView2_data;
    ArrayList<Object>ImageUrl;
//Initilize them in the oncreate methode and add data to them.
 @Override
    protected void onCreate(Bundle savedInstanceState) {
       TextView1_data=new ArrayList<>();
       TextView2_data=new ArrayList<>();
       imageUrl=new ArrayList<>();

       TextView1_data.add("Github");
       TextView1_data.add("gfg");
       TextView1_data.add("Code chef");

       TextView2_data.add("Open Source platform");
       TextView2_data.add("Coding Question platform");
       TextView2_data.add("Online coding platform");

       imageUrl.add(img1);
       imageUrl.add(img2);
       imageUrl.add(img3);
   }
```
then, Called the add data methode
```
flexilist.addData_to_TWO_TEXT_VIEW_ONE_IMAGE(TextView1_data,TextView2_data,imageUrl);
```
There are total four methodes for four type Layouts to add data to them.
```
flexilist.addData_to_ONE_TEXT_VIEW();
flexilist.addData_to_TWO_TEXT_VIEW();
flexilist.addData_to_ONE_TEXT_VIEW_ONE_IMAGE();
flexilist.addData_to_TWO_TEXT_VIEW_ONE_IMAGE()
```
Then to work the FlexList finally add the methode
```
//This methode will set your FlexList to the Recycler View.
flexilist.setFlexiList()
```
To add onclick methode to FlexiList impliment the onFlexlistClicked interface
```
public class MainActivity extends AppCompatActivity implements onFlexlistClicked
//And must call the following function to add the clickListener
flexilist.setFlexiListClicked();
```
Similarly to add swipe Action and Long click action implement folloing interface and call following methodes
```
//for Swipe action
public class MainActivity extends AppCompatActivity implements onSwipeAction
//and must call
flexilist.getSwipeAction(FlexiList.SWIPE_BOTH_LEFT_AND_RIGHT)
//here one parameter needed
FlexiList.SWIPE_BOTH_LEFT_AND_RIGHT (recycle view item swipe both side).
FlexiList.SWIPE_LEFT (recycle view item swipe left side).
FlexiList.SWIPE_RIGHT (recycle view item swipe right side).


//for Long Click action.
public class MainActivity extends AppCompatActivity implements onLongClicked
//must call
flexiList.setOnlongclicked();
```
## Built with
- Java
- XML
- Android Studio

## Getting Help
To report a specific problem or feature request, [open a new issue](https://github.com/moyukh00145/FlexiList-Android/issues) on Github. For questions, suggestions, or anything else, email .

## Authors

<a href="https://github.com/moyukh00145/FlexiList-Android/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=moyukh00145/FlexiList-Android"/>
</a>

## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/moyukh00145/FlexiList-Android/blob/master/LICENSE) file for details.

