package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import business.Controllore;

public class MyMouseListener {

	MouseAdapter mouseAdapter = new MouseAdapter() {

		@Override
		public void mouseClicked(final MouseEvent e) {
			Controllore.mouseClicked(e);
		}
	};

	MouseMotionAdapter mouseMotionAdapter = new MouseMotionAdapter() {
		@Override
		public void mouseMoved(final MouseEvent e) {
			Controllore.mouseMoved(e);
		}

		@Override
		public void mouseDragged(final MouseEvent e) {
			Controllore.mouseDragged(e);
		};
	};

	public MouseAdapter getMouseAdapter() {
		return mouseAdapter;
	}

	public MouseMotionAdapter getMouseMotionAdapter() {
		return mouseMotionAdapter;
	}
}
