/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { HcPortalTestModule } from '../../../test.module';
import { MenstrualCycleDetailComponent } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle-detail.component';
import { MenstrualCycleService } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle.service';
import { MenstrualCycle } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle.model';

describe('Component Tests', () => {

    describe('MenstrualCycle Management Detail Component', () => {
        let comp: MenstrualCycleDetailComponent;
        let fixture: ComponentFixture<MenstrualCycleDetailComponent>;
        let service: MenstrualCycleService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [MenstrualCycleDetailComponent],
                providers: [
                    MenstrualCycleService
                ]
            })
            .overrideTemplate(MenstrualCycleDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(MenstrualCycleDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(MenstrualCycleService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new MenstrualCycle('123')
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith('123');
                expect(comp.menstrualCycle).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
