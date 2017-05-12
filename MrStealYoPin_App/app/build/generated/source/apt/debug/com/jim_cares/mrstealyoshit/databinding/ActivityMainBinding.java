package com.jim_cares.mrstealyoshit.databinding;
import com.jim_cares.mrstealyoshit.R;
import com.jim_cares.mrstealyoshit.BR;
import android.view.View;
public class ActivityMainBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.editText, 1);
        sViewsWithIds.put(R.id.buttonSeven, 2);
        sViewsWithIds.put(R.id.buttonEight, 3);
        sViewsWithIds.put(R.id.buttonNine, 4);
        sViewsWithIds.put(R.id.buttonFour, 5);
        sViewsWithIds.put(R.id.buttonFive, 6);
        sViewsWithIds.put(R.id.buttonSix, 7);
        sViewsWithIds.put(R.id.buttonOne, 8);
        sViewsWithIds.put(R.id.buttonTwo, 9);
        sViewsWithIds.put(R.id.buttonThree, 10);
        sViewsWithIds.put(R.id.buttonZero, 11);
        sViewsWithIds.put(R.id.buttonClear, 12);
        sViewsWithIds.put(R.id.buttonAccept, 13);
    }
    // views
    public final android.widget.RelativeLayout activityMain;
    public final android.widget.Button buttonAccept;
    public final android.widget.Button buttonClear;
    public final android.widget.Button buttonEight;
    public final android.widget.Button buttonFive;
    public final android.widget.Button buttonFour;
    public final android.widget.Button buttonNine;
    public final android.widget.Button buttonOne;
    public final android.widget.Button buttonSeven;
    public final android.widget.Button buttonSix;
    public final android.widget.Button buttonThree;
    public final android.widget.Button buttonTwo;
    public final android.widget.Button buttonZero;
    public final android.widget.EditText editText;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds);
        this.activityMain = (android.widget.RelativeLayout) bindings[0];
        this.activityMain.setTag(null);
        this.buttonAccept = (android.widget.Button) bindings[13];
        this.buttonClear = (android.widget.Button) bindings[12];
        this.buttonEight = (android.widget.Button) bindings[3];
        this.buttonFive = (android.widget.Button) bindings[6];
        this.buttonFour = (android.widget.Button) bindings[5];
        this.buttonNine = (android.widget.Button) bindings[4];
        this.buttonOne = (android.widget.Button) bindings[8];
        this.buttonSeven = (android.widget.Button) bindings[2];
        this.buttonSix = (android.widget.Button) bindings[7];
        this.buttonThree = (android.widget.Button) bindings[10];
        this.buttonTwo = (android.widget.Button) bindings[9];
        this.buttonZero = (android.widget.Button) bindings[11];
        this.editText = (android.widget.EditText) bindings[1];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
        }
        return false;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityMainBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityMainBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.jim_cares.mrstealyoshit.R.layout.activity_main, root, attachToRoot, bindingComponent);
    }
    public static ActivityMainBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityMainBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.jim_cares.mrstealyoshit.R.layout.activity_main, null, false), bindingComponent);
    }
    public static ActivityMainBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityMainBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_main_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityMainBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}